/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rtech.greenReceipt.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author varunFG
 */
@Entity
@Table(name = "receipts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receipts.findAll", query = "SELECT r FROM Receipts r")
    , @NamedQuery(name = "Receipts.findByReceiptNumber", query = "SELECT r FROM Receipts r WHERE r.receiptNumber = :receiptNumber")
    , @NamedQuery(name = "Receipts.findByDate", query = "SELECT r FROM Receipts r WHERE r.date = :date")
    , @NamedQuery(name = "Receipts.findByStoreName", query = "SELECT r FROM Receipts r WHERE r.storeName = :storeName")
    , @NamedQuery(name = "Receipts.findByCustomerName", query = "SELECT r FROM Receipts r WHERE r.customerName = :customerName")
    , @NamedQuery(name = "Receipts.findByCustimerAddress", query = "SELECT r FROM Receipts r WHERE r.custimerAddress = :custimerAddress")
    , @NamedQuery(name = "Receipts.findByCustomerContactNumber", query = "SELECT r FROM Receipts r WHERE r.customerContactNumber = :customerContactNumber")
    , @NamedQuery(name = "Receipts.findByCustomerEmail", query = "SELECT r FROM Receipts r WHERE r.customerEmail = :customerEmail")
    , @NamedQuery(name = "Receipts.findByItemCondition", query = "SELECT r FROM Receipts r WHERE r.itemCondition = :itemCondition")
    , @NamedQuery(name = "Receipts.findByItemDescription", query = "SELECT r FROM Receipts r WHERE r.itemDescription = :itemDescription")
    , @NamedQuery(name = "Receipts.findByItemNumber", query = "SELECT r FROM Receipts r WHERE r.itemNumber = :itemNumber")
    , @NamedQuery(name = "Receipts.findByReceiptAmount", query = "SELECT r FROM Receipts r WHERE r.receiptAmount = :receiptAmount")
    , @NamedQuery(name = "Receipts.findByCustomerIdType", query = "SELECT r FROM Receipts r WHERE r.customerIdType = :customerIdType")
    , @NamedQuery(name = "Receipts.findByCustomerIdNumber", query = "SELECT r FROM Receipts r WHERE r.customerIdNumber = :customerIdNumber")
    , @NamedQuery(name = "Receipts.findByCustomerIdExpiryDate", query = "SELECT r FROM Receipts r WHERE r.customerIdExpiryDate = :customerIdExpiryDate")
    , @NamedQuery(name = "Receipts.findBySaleManager", query = "SELECT r FROM Receipts r WHERE r.saleManager = :saleManager")
    , @NamedQuery(name = "Receipts.findByRenderCustomerIdImage", query = "SELECT r FROM Receipts r WHERE r.renderCustomerIdImage = :renderCustomerIdImage")})
public class Receipts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RECEIPT_NUMBER")
    private Integer receiptNumber;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 50)
    @Column(name = "STORE_NAME")
    private String storeName;
    @Size(max = 100)
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    @Size(max = 250)
    @Column(name = "CUSTIMER_ADDRESS")
    private String custimerAddress;
    @Size(max = 20)
    @Column(name = "CUSTOMER_CONTACT_NUMBER")
    private String customerContactNumber;
    @Size(max = 100)
    @Column(name = "CUSTOMER_EMAIL")
    private String customerEmail;
    @Size(max = 10)
    @Column(name = "ITEM_CONDITION")
    private String itemCondition;
    @Size(max = 200)
    @Column(name = "ITEM_DESCRIPTION")
    private String itemDescription;
    @Size(max = 50)
    @Column(name = "ITEM_NUMBER")
    private String itemNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RECEIPT_AMOUNT")
    private BigDecimal receiptAmount;
    @Size(max = 50)
    @Column(name = "CUSTOMER_ID_TYPE")
    private String customerIdType;
    @Size(max = 50)
    @Column(name = "CUSTOMER_ID_NUMBER")
    private String customerIdNumber;
    @Column(name = "CUSTOMER_ID_EXPIRY_DATE")
    @Temporal(TemporalType.DATE)
    private Date customerIdExpiryDate;
    @Size(max = 100)
    @Column(name = "SALE_MANAGER")
    private String saleManager;
    @Lob
    @Size(max = 65535)
    @Column(name = "SIGNATURE_VALUE")
    private String signatureValue;
    @Lob
    @Column(name = "CUSTOMER_ID_IMAGE")
    private byte[] customerIdImage;
    @Column(name = "RENDER_CUSTOMER_ID_IMAGE")
    private Character renderCustomerIdImage;
    @Lob
    @Size(max = 65535)
    @Column(name = "PHOTO_ID_FILENAME")
    private String photoIdFilename;

    public Receipts() {
    }

    public Receipts(Integer receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public Integer getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(Integer receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustimerAddress() {
        return custimerAddress;
    }

    public void setCustimerAddress(String custimerAddress) {
        this.custimerAddress = custimerAddress;
    }

    public String getCustomerContactNumber() {
        return customerContactNumber;
    }

    public void setCustomerContactNumber(String customerContactNumber) {
        this.customerContactNumber = customerContactNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getItemCondition() {
        return itemCondition;
    }

    public void setItemCondition(String itemCondition) {
        this.itemCondition = itemCondition;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public BigDecimal getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(BigDecimal receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public String getCustomerIdType() {
        return customerIdType;
    }

    public void setCustomerIdType(String customerIdType) {
        this.customerIdType = customerIdType;
    }

    public String getCustomerIdNumber() {
        return customerIdNumber;
    }

    public void setCustomerIdNumber(String customerIdNumber) {
        this.customerIdNumber = customerIdNumber;
    }

    public Date getCustomerIdExpiryDate() {
        return customerIdExpiryDate;
    }

    public void setCustomerIdExpiryDate(Date customerIdExpiryDate) {
        this.customerIdExpiryDate = customerIdExpiryDate;
    }

    public String getSaleManager() {
        return saleManager;
    }

    public void setSaleManager(String saleManager) {
        this.saleManager = saleManager;
    }

    public String getSignatureValue() {
        return signatureValue;
    }

    public void setSignatureValue(String signatureValue) {
        this.signatureValue = signatureValue;
    }

    public byte[] getCustomerIdImage() {
        return customerIdImage;
    }

    public void setCustomerIdImage(byte[] customerIdImage) {
        this.customerIdImage = customerIdImage;
    }

    public Character getRenderCustomerIdImage() {
        return renderCustomerIdImage;
    }

    public void setRenderCustomerIdImage(Character renderCustomerIdImage) {
        this.renderCustomerIdImage = renderCustomerIdImage;
    }

    public String getPhotoIdFilename() {
        return photoIdFilename;
    }

    public void setPhotoIdFilename(String photoIdFilename) {
        this.photoIdFilename = photoIdFilename;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receiptNumber != null ? receiptNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receipts)) {
            return false;
        }
        Receipts other = (Receipts) object;
        if ((this.receiptNumber == null && other.receiptNumber != null) || (this.receiptNumber != null && !this.receiptNumber.equals(other.receiptNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rtech.greenReceipt.model.Receipts[ receiptNumber=" + receiptNumber + " ]";
    }
    
}
