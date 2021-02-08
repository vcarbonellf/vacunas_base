package org.example.vacunas;

import com.google.firebase.firestore.FirebaseFirestore;

public class VacunasFirestore {
    public static String VACUNAS = "vacunas";
    static String SERVIDOR="http://curso-firebase2021.000webhostapp.com/";

    public static void crearVacunas() {
        Vacuna vacuna;
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        vacuna = new Vacuna("Ad5-nCoV"
                , "CanSino Biologics"
                , "China"
                , "FASE 2"
                , SERVIDOR+"imagenes/china.jpg");
        db.collection(VACUNAS).document("Ad5-nCoV").set(vacuna);
        vacuna = new Vacuna("AZD1222"
                , "Universidad Oxford y AstraZeneca"
                , "Reino Unido"
                , "FASE 2"
                , SERVIDOR+"imagenes/reinoUnido.jpg");
        db.collection(VACUNAS).document("AZD1222").set(vacuna);
        vacuna = new Vacuna("mRNA-1273"
                , " Moderna"
                , "Estados Unidos"
                , "FASE 3"
                , SERVIDOR+"imagenes/estadosUnidos.jpg");
        db.collection(VACUNAS).document("mRNA-1273").set(vacuna);
        vacuna = new Vacuna("Covid-19-aAPC"
                , " Instituto Médico de Shenzhen"
                , "China"
                , "FASE 1"
                , SERVIDOR+"imagenes/china.jpg");
        db.collection(VACUNAS).document("Covid-19-aAPC ").set(vacuna);
        vacuna = new Vacuna("BNT162"
                , "BioNTech y Pfizer"
                , "Alemania"
                , "FASE 3"
                , SERVIDOR+"imagenes/alemania.jpg");
        db.collection(VACUNAS).document("BNT162").set(vacuna);
    }
}
