/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getObjectProperties(obj, recursive, level){
    if (typeof recursive == "undefined")
            recursive = false;

    if (typeof level == "undefined")
            level = 0;
    var tab = "";
    for(var i=0; i < level ; i++){
            tab += "\t";
    }

    var result = tab + "OBJECT " + obj;

    //console.log("level : "+level+" - tab : "+tab);

    for (prop in obj){
            var sub_obj = obj[prop];
            //console.log("sub_obj : "+sub_obj);

            result = result + "\n" + tab + obj + " has property '"+prop+"' ("+(typeof sub_obj)+")";

            if (typeof sub_obj != "function")
                    result = result + " : "+sub_obj;

            if (recursive && (typeof sub_obj == "object"))
            {
                    result = result + "\n" + getObjectProperties(sub_obj, recursive, level+1);
            }
    }

    return result;
}