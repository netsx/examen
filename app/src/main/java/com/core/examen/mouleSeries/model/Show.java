
package com.core.examen.mouleSeries.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;

public class Show {



    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("genres")
    @Expose
    private List<String> genres = null;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("runtime")
    @Expose
    private int runtime;
    @SerializedName("premiered")
    @Expose
    private String premiered;
    @SerializedName("officialSite")
    @Expose
    private String officialSite;
    @SerializedName("schedule")
    @Expose
    private String schedule;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("weight")
    @Expose
    private int weight;
    @SerializedName("network")
    @Expose
    private String network;
    @SerializedName("webChannel")
    @Expose
    private String webChannel;
    @SerializedName("externals")
    @Expose
    private String externals;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("updated")
    @Expose
    private int updated;
    @SerializedName("_links")
    @Expose
    private String links;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getPremiered() {
        return premiered;
    }

    public void setPremiered(String premiered) {
        this.premiered = premiered;
    }

    public String getOfficialSite() {
        return officialSite;
    }

    public void setOfficialSite(String officialSite) {
        this.officialSite = officialSite;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public Object getWebChannel() {
        return webChannel;
    }

    public void setWebChannel(String webChannel) {
        this.webChannel = webChannel;
    }

    public String getExternals() {
        return externals;
    }

    public void setExternals(String externals) {
        this.externals = externals;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getUpdated() {
        return updated;
    }

    public void setUpdated(int updated) {
        this.updated = updated;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }
}

