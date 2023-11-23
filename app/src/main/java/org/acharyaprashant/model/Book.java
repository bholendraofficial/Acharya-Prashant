/*
 * Copyright (c) 2023. Bholendra Singh
 */

package org.acharyaprashant.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Book {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("coverImage")
    @Expose
    private String coverImage;
    @SerializedName("shortDescription")
    @Expose
    private String shortDescription;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("isUpcoming")
    @Expose
    private Boolean isUpcoming;
    @SerializedName("isDraft")
    @Expose
    private Boolean isDraft;
    @SerializedName("pages")
    @Expose
    private Integer pages;
    @SerializedName("paperBookURL")
    @Expose
    private String paperBookURL;
    @SerializedName("copiesTaken")
    @Expose
    private Integer copiesTaken;
    @SerializedName("showPaperBookInApp")
    @Expose
    private Boolean showPaperBookInApp;
    @SerializedName("appleIAP")
    @Expose
    private AppleIAP appleIAP;
    @SerializedName("originalAmount")
    @Expose
    private Integer originalAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean getIsUpcoming() {
        return isUpcoming;
    }

    public void setIsUpcoming(Boolean isUpcoming) {
        this.isUpcoming = isUpcoming;
    }

    public Boolean getIsDraft() {
        return isDraft;
    }

    public void setIsDraft(Boolean isDraft) {
        this.isDraft = isDraft;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getPaperBookURL() {
        return paperBookURL;
    }

    public void setPaperBookURL(String paperBookURL) {
        this.paperBookURL = paperBookURL;
    }

    public Integer getCopiesTaken() {
        return copiesTaken;
    }

    public void setCopiesTaken(Integer copiesTaken) {
        this.copiesTaken = copiesTaken;
    }

    public Boolean getShowPaperBookInApp() {
        return showPaperBookInApp;
    }

    public void setShowPaperBookInApp(Boolean showPaperBookInApp) {
        this.showPaperBookInApp = showPaperBookInApp;
    }

    public AppleIAP getAppleIAP() {
        return appleIAP;
    }

    public void setAppleIAP(AppleIAP appleIAP) {
        this.appleIAP = appleIAP;
    }

    public Integer getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(Integer originalAmount) {
        this.originalAmount = originalAmount;
    }

    public static class AppleIAP {

        @SerializedName("productId")
        @Expose
        private String productId;
        @SerializedName("quantity")
        @Expose
        private Integer quantity;

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

    }
}