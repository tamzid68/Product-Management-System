package com.store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "products")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//IDENTITY
    @Column(name = "Id")
    private long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Brand")
    private String brand;
    @Column(name = "Category")
    private String category;
    @Column(name = "Price")
    private double price;

    @Column(columnDefinition = "TEXT",name = "Description")
    private String description;
    @Temporal(TemporalType.DATE)
    @Column(name = "Date")
    private Date createdAt;
    private String imageFileName;

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", imageFileName='" + imageFileName + '\'' +
                '}';
    }


}
