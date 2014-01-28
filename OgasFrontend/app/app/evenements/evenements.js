'use strict';

/* Controllers */


angular.module('evenements', ['ngTable']).
        config(['$routeProvider', function($routeProvider) {
                $routeProvider.when('/evenements', {templateUrl: 'app/evenements/evenements_onglets.html', controller: 'GeneralCtrl'});
            }]).
        controller('GeneralCtrl', ['$scope', 'ngTableParams', '$filter', function($scope, ngTableParams, $filter) {
                var data = [{name: "event1", date: "20/01/2013", selected: true},
                    {name: "event2", date: "25/01/2013", selected: false},
                    {name: "event3", date: "20/06/2014", selected: false},
                    {name: "event4", date: "05/10/2012", selected: false},
                    {name: "event5", date: "22/07/2015", selected: false},
                    {name: "event6", date: "20/02/2013", selected: false},
                    {name: "event7", date: "18/09/2013", selected: false},
                    {name: "event8", date: "20/01/2016", selected: false}];


                $scope.tabEvenements = [{name: "event1", date: "20/01/2013", selected: true},
                    {name: "event2", date: "25/01/2013", selected: false},
                    {name: "event3", date: "20/06/2014", selected: false},
                    {name: "event4", date: "05/10/2012", selected: false},
                    {name: "event5", date: "22/07/2015", selected: false},
                    {name: "event6", date: "20/02/2013", selected: false},
                    {name: "event7", date: "18/09/2013", selected: false},
                    {name: "event8", date: "20/01/2016", selected: false}];

                $scope.tabTitres = [
                    {title: "Général", content: '/OgasFrontend/app/evenements/evenements_general.html'},
                    {title: "Entreprises", content: "/OgasFrontend/app/evenements/evenements_entreprises.html"},
                    {title: "Etudiants", content: "/OgasFrontend/app/evenements/evenements_etudiants.html"},
                    {title: "Salles", content: "/OgasFrontend/app/evenements/evenements_salles.html"},
                    {title: "Voeux", content: "/OgasFrontend/app/evenements/voeux.html"},
                    {title: "Planning", content: "/OgasFrontend/app/evenements/planning.html"}
                ];

                $scope.tabEntreprises = [{name: "Moroni", age: 50, selected: true},
                    {name: "Tiancum", age: 43, selected: true},
                    {name: "Jacob", age: 27, selected: false},
                    {name: "Nephi", age: 29, selected: false},
                    {name: "Enos", age: 34, selected: false},
                    {name: "Tiancum", age: 43, selected: false},
                    {name: "Jacob", age: 27, selected: false},
                    {name: "Nephi", age: 29, selected: true},
                    {name: "Enos", age: 34, selected: false},
                    {name: "Tiancum", age: 43, selected: false}];



                $scope.tabEtudiants = [{
                        "id": 1,
                        "annee": "2011-2014",
                        "lm": 138661285100,
                        "ln": "Smith",
                        "fn": "John",
                        "dc": "CEO",
                        "em": "j.smith@company.com",
                        "ph": "617-321-4567",
                        "ac": true,
                        "dl": false
                    }
                    ,
                    {
                        "id": 2,
                        "annee": "2012-2015",
                        "lm": 138661285200,
                        "ln": "Taylor",
                        "fn": "Lisa",
                        "dc": "VP of Marketing",
                        "em": "l.taylor@company.com",
                        "ph": "617-522-5588",
                        "ac": true,
                        "dl": false
                    },
                    {
                        "id": 3,
                        "annee": "2011-2014",
                        "lm": 138661285300,
                        "ln": "Jones",
                        "fn": "James",
                        "dc": "VP of Sales",
                        "em": "j.jones@company.com",
                        "ph": "617-589-9977",
                        "ac": true,
                        "dl": false
                    },
                    {
                        "id": 4,
                        "annee": "2011-2014",
                        "lm": 138661285400,
                        "ln": "Wong",
                        "fn": "Paul",
                        "dc": "VP of Engineering",
                        "em": "p.wong@company.com",
                        "ph": "617-245-9785",
                        "ac": true,
                        "dl": false
                    },
                    {
                        "id": 5,
                        "annee": "2012-2015",
                        "lm": 138661285500,
                        "ln": "King",
                        "fn": "Alice",
                        "dc": "Architect",
                        "em": "a.king@company.com",
                        "ph": "617-244-1177",
                        "ac": true,
                        "dl": false
                    },
                    {
                        "id": 6,
                        "annee": "2013-2016",
                        "lm": 138661285600,
                        "ln": "Brown",
                        "fn": "Jan",
                        "dc": "Software Engineer",
                        "em": "j.brown@company.com",
                        "ph": "617-568-9863",
                        "ac": true,
                        "dl": false
                    },
                    {
                        "id": 7,
                        "annee": "2011-2014",
                        "lm": 138661285700,
                        "ln": "Garcia",
                        "fn": "Ami",
                        "dc": "Software Engineer",
                        "em": "a.garcia@company.com",
                        "ph": "617-327-9966",
                        "ac": true,
                        "dl": false
                    },
                    {
                        "id": 8,
                        "annee": "2011-2014",
                        "lm": 138661285800,
                        "ln": "Green",
                        "fn": "Jack",
                        "dc": "Software Engineer",
                        "em": "j.green@company.com",
                        "ph": "617-565-9966",
                        "ac": true,
                        "dl": false
                    },
                    {
                        "id": 9,
                        "annee": "2011-2014",
                        "lm": 138661285900,
                        "ln": "Liesen",
                        "fn": "Abraham",
                        "dc": "Plumber",
                        "em": "a.liesen@company.com",
                        "ph": "617-523-4468",
                        "ac": true,
                        "dl": false
                    },
                    {
                        "id": 10,
                        "annee": "2013-2016",
                        "lm": 138661286000,
                        "ln": "Bower",
                        "fn": "Angela",
                        "dc": "Product Manager",
                        "em": "a.bower@company.com",
                        "ph": "617-877-3434",
                        "ac": true,
                        "dl": false
                    },
                    {
                        "id": 11,
                        "annee": "2013-2016",
                        "lm": 138661286100,
                        "ln": "Davidoff",
                        "fn": "Fjodor",
                        "dc": "Database Admin",
                        "em": "f.davidoff@company.com",
                        "ph": "617-446-9999",
                        "ac": true,
                        "dl": false
                    },
                    {
                        "id": 12,
                        "annee": "2012-2015",
                        "lm": 138661286200,
                        "ln": "Vitrovic",
                        "fn": "Biljana",
                        "dc": "Director of Communications",
                        "em": "b.vitrovic@company.com",
                        "ph": "617-111-1111",
                        "ac": true,
                        "dl": false
                    },
                    {
                        "id": 13,
                        "annee": "2013-2016",
                        "lm": 138661286300,
                        "ln": "Valet",
                        "fn": "Guillaume",
                        "dc": "Software Engineer",
                        "em": "g.valet@company.com",
                        "ph": "617-565-4412",
                        "ac": true,
                        "dl": false
                    },
                    {
                        "id": 14,
                        "annee": "2012-2015",
                        "lm": 138661286400,
                        "ln": "Tran",
                        "fn": "Min",
                        "dc": "Gui Designer",
                        "em": "m.tran@company.com",
                        "ph": "617-866-2554",
                        "ac": true,
                        "dl": false
                    }];

                $scope.tabSalles = [{name: "Salle 15", localisation: "Polytech' Lyon", selected: true},
                    {name: "Salle 16", localisation: "Polytech' Lyon", selected: true},
                    {name: "Salle 17", localisation: "Polytech' Lyon", selected: false},
                    {name: "Salle 20", localisation: "Polytech' Lyon", selected: false},
                    {name: "Lippman", localisation: "Insa", selected: false},
                    {name: "Salle 110", localisation: "Polytech' Lyon", selected: false},
                    {name: "Salle 111", localisation: "Polytech' Lyon", selected: false},];
            }]);

