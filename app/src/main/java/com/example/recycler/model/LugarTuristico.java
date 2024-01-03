package com.example.recycler.model;

import com.google.gson.annotations.SerializedName;



public class LugarTuristico {
    @SerializedName("categoria_id")
    private String categoria_id;
    @SerializedName("categoria")
    private String categoria;
    @SerializedName("subcategoria")
    private String subcategoria;
    @SerializedName("id")
    private String id;
    @SerializedName("subcategoria_id")
    private String subcategoria_id;
    @SerializedName("nombre_lugar")
    private String nombre_lugar;
    @SerializedName("descripcion")
    private String descripcion;
    @SerializedName("direccion")
    private String direccion;
    @SerializedName("logo")
    private String logo;
    @SerializedName("imagenes_gif")
    private String imagenes_gif;
    @SerializedName("puntuacion")
    private String puntuacion;
    @SerializedName("telefono")
    private String telefono;
    @SerializedName("anio")
    private String anio;

    public String getCategoria_id() {
        return categoria_id;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public String getId() {
        return id;
    }

    public String getSubcategoria_id() {
        return subcategoria_id;
    }

    public String getNombre_lugar() {
        return nombre_lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLogo() {
        return logo;
    }

    public String getImagenes_gif() {
        return imagenes_gif;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getAnio() {
        return anio;
    }

}
