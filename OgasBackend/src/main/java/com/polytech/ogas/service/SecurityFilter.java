/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polytech.ogas.service;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;


import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class SecurityFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext)
                    throws IOException {
        boolean authSucceded = false;
        UriInfo uri = requestContext.getUriInfo();
        //Récupération des paramètres de la query string
        MultivaluedMap<String,String> params = uri.getQueryParameters();
        String signature = params.getFirst("signature");
        String user = params.getFirst("user");
        long timestamp = Long.parseLong(params.getFirst("timestamp"));
        
        //Reconstitution de la signature à partir des paramètres
        String httpVerb = requestContext.getMethod();
        String url = uri.getAbsolutePath().toString();
        String salt = "salt";
        //Récupération du mot de passe de l'user dans la BD
        String pwdBD = "pagnier"; //TODO récupérer le vrai password crypté dans la BD
        //hachage en sha1 du password avec le sel
        String hachedPwd = "";
        try{
            hachedPwd = sha1(sha1(pwdBD) + salt); //TODO enlever le sha1 autour du mot de passe (il sera déjà crypté)
        }catch(Exception e){
            e.printStackTrace();
        }
        //requete HTTP pour la signature
        String httpRequest = httpVerb + ':' + url + "?user=" + user + "&timestamp=" + timestamp;
        
        //Reconstitution de la signature
        String calcSignature = hmacDigest(httpRequest, hachedPwd);
        
        if(signature.equals(calcSignature)){
            //Test du timestamp, on rejette les requêtes vieilles de plus de 30 secondes
            long timestampNow = System.currentTimeMillis();
            long dif = (timestampNow - timestamp) / 1000;
            if(dif < 30){
                authSucceded = true;
            }
        }
            
        if(!authSucceded){
            requestContext.abortWith(Response
                        .status(Response.Status.UNAUTHORIZED)
                        .entity(params.toString())
                        .build());
        }
    }
    
    public String sha1(String input) throws Exception {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
    
    private static String Hmac(String pKey, String pStringToSign){
        String lSignature = "None";
        try
        {
            Mac lMac = Mac.getInstance("HmacSHA1");
            SecretKeySpec lSecret = new SecretKeySpec(pKey.getBytes(), "HmacSHA1");
            lMac.init(lSecret);

            byte[] lDigest = lMac.doFinal(pStringToSign.getBytes());
            BigInteger lHash = new BigInteger(1, lDigest);
            lSignature = lHash.toString(16);
            if ((lSignature.length() % 2) != 0) {
              lSignature = "0" + lSignature;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lSignature;
    }
    public String hmacDigest(String msg, String keyString) {
        String algo = "HmacSHA1";
        String digest = null;
        try {
            SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"), algo);
            Mac mac = Mac.getInstance(algo);
            mac.init(key);

            byte[] bytes = mac.doFinal(msg.getBytes("ASCII"));

            StringBuffer hash = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
              String hex = Integer.toHexString(0xFF & bytes[i]);
              if (hex.length() == 1) {
                hash.append('0');
              }
              hash.append(hex);
            }
            digest = hash.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return digest;
    }

    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
        if (response != null && response.getMediaType() != null) {
            String contentType = response.getMediaType().toString();
            if (contentType != null && !contentType.contains("charset")) {
                contentType = contentType + ";charset=utf-8";
                response.getHeaders().putSingle("Content-Type", contentType);
            }
        }
    }
}
