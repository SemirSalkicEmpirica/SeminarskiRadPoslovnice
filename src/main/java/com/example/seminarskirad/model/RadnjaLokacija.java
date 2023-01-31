package com.example.seminarskirad.model;

public class RadnjaLokacija {
    private Long id;
    private String grad;
    private String imeObjekta;

    public RadnjaLokacija(String grad, String imeObjekta) {
        this.grad = grad;
        this.imeObjekta = imeObjekta;
    }

    public RadnjaLokacija(Long id, String grad, String imeObjekta) {
        this.id = id;
        this.grad = grad;
        this.imeObjekta = imeObjekta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getImeObjekta() {
        return imeObjekta;
    }

    public void setImeObjekta(String imeObjekta) {
        this.imeObjekta = imeObjekta;
    }
}
