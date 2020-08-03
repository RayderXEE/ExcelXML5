package com.example.demo;

import java.io.IOException;

public class XMLParams {

    ExcelParams excelParams;

    String nscf;
    String dscf;

    String nprd;
    String dprd;

    String znacen;
    String identif;

    String naimTov;
    String nalSt;
    String sumNal;
    String stTovYcNal;

    String kpp;

    public XMLParams(ExcelParams excelParams) {
        this.excelParams = excelParams;
        fillParams();
    }

    void fillParams() {
        String s;

        // SCF
        s = excelParams.NnDofSCF.split("№ ")[1].split(" ")[0];
        System.out.println(s);
        nscf = s;

        s = excelParams.NnDofSCF.split("от ")[1].split("г")[0];
        System.out.println(s);
        dscf = s;

        // PRD
        s = excelParams.NnDofPRD.split(" ")[0];
        System.out.println(s);
        nprd = s;

        s = excelParams.NnDofPRD.split("от ")[1].split("г")[0];
        System.out.println(s);
        dprd = s;

        // textinf, identif, znacen

        int posZnacen = excelParams.TextInf.indexOf("Заказ");
        s = excelParams.TextInf.substring(posZnacen);
        System.out.println(s);
        znacen = s;

        s = excelParams.TextInf.substring(0, posZnacen-1);
        System.out.println(s);
        identif = s;

        //
        naimTov = excelParams.NaimTov;

        String nalSt1 = excelParams.NalSt.split("%")[0];
        String nalSt2 = excelParams.NalSt.split("%")[1].substring(1);

        nalSt = nalSt1 + "/" + nalSt2;

        sumNal  = excelParams.SumNal.replace(",","");

        stTovYcNal = excelParams.stTovYcNal.replace(",","");

        // params from config

        Configer configer = null;
        try {
            configer = new Configer("config.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        kpp = configer.getParam("kpp");

        System.out.println(naimTov);
        System.out.println(nalSt);
        System.out.println(sumNal);
        System.out.println(stTovYcNal);
        System.out.println(kpp);
    }

}
