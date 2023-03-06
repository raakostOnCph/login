package com.example.demo5.Entitet;

public class Person
{
    String navn;
    String kode;

    public Person(String navn, String kode)
    {
        this.navn = navn;
        this.kode = kode;
    }

    public String getNavn()
    {
        return navn;
    }

    public String getKode()
    {
        return kode;
    }
}
