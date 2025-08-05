package com.devsuperior.dsmeta.dto;

public class SellerDto {
    private Long id;
    private String name;
    private String email;
    private String phone;

    public SellerDto() {
    }

    public SellerDto(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
