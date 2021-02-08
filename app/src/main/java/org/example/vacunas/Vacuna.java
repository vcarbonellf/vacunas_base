package org.example.vacunas;

public class Vacuna {
    private String vacuna;
    private String empresa;
    private String ubicacion;
    private String estado;
    private String imagen;

    public Vacuna() {}

    public Vacuna(String vacuna, String empresa, String ubicacion, String estado, String imagen) {
        this.vacuna = vacuna;
        this.empresa = empresa;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.imagen = imagen;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}

