package kg.laptopshop.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Product {

    @Id
    @GeneratedValue
    Long id;

    //private String description;
    private String modelLaptop;
    private String company;
    private Double diagonal;
    private String cpu;
    private String hardDiskType;
    private String operatingSystem;
    private Long amountRam;
    private Long storageCapacity;
    private Double price;

    @Lob
    private byte[] image;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelLaptop() {
        return modelLaptop;
    }

    public void setModelLaptop(String modelLaptop) {
        this.modelLaptop = modelLaptop;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(Double diagonal) {
        this.diagonal = diagonal;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getHardDiskType() {
        return hardDiskType;
    }

    public void setHardDiskType(String hardDiskType) {
        this.hardDiskType = hardDiskType;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Long getAmountRam() {
        return amountRam;
    }

    public void setAmountRam(Long amountRam) {
        this.amountRam = amountRam;
    }

    public Long getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(Long storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
