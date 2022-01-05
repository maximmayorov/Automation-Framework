package com.epam.ta.model;

import java.util.Objects;

public class CalculatorData {

    private String instances;
    private String os;
    private String machineClass;
    private String series;
    private String machineType;
    private boolean addGPUs;
    private String gpuType;
    private String numberOfGPUs;
    private String ssd;
    private String location;
    private String committedUsage;

    public CalculatorData() {

    }

    public CalculatorData(String instances, String os, String machineClass, String series, String machineType, boolean addGPUs, String gpuType, String numberOfGPUs, String ssd, String location, String committedUsage) {
        this.instances = instances;
        this.os = os;
        this.machineClass = machineClass;
        this.series = series;
        this.machineType = machineType;
        this.addGPUs = addGPUs;
        this.gpuType = gpuType;
        this.numberOfGPUs = numberOfGPUs;
        this.ssd = ssd;
        this.location = location;
        this.committedUsage = committedUsage;
    }

    public String getInstances() {
        return instances;
    }

    public String getOs() {
        return os;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public String getSeries() {
        return series;
    }

    public String getMachineType() {
        return machineType;
    }

    public boolean isAddGPUs() {
        return addGPUs;
    }

    public String getGpuType() {
        return gpuType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public String getSsd() {
        return ssd;
    }

    public String getLocation() {
        return location;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setInstances(String instances) {
        this.instances = instances;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public void setAddGPUs(boolean addGPUs) {
        this.addGPUs = addGPUs;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public String toString() {
        return "CalculatorData{" +
                "instances='" + instances + '\'' +
                ", os='" + os + '\'' +
                ", machineClass='" + machineClass + '\'' +
                ", series='" + series + '\'' +
                ", machineType='" + machineType + '\'' +
                ", addGPUs=" + addGPUs +
                ", gpuType='" + gpuType + '\'' +
                ", numberOfGPUs='" + numberOfGPUs + '\'' +
                ", ssd='" + ssd + '\'' +
                ", location='" + location + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculatorData that = (CalculatorData) o;
        return addGPUs == that.addGPUs &&
                Objects.equals(instances, that.instances) &&
                Objects.equals(os, that.os) &&
                Objects.equals(machineClass, that.machineClass) &&
                Objects.equals(series, that.series) &&
                Objects.equals(machineType, that.machineType) &&
                Objects.equals(gpuType, that.gpuType) &&
                Objects.equals(numberOfGPUs, that.numberOfGPUs) &&
                Objects.equals(ssd, that.ssd) &&
                Objects.equals(location, that.location) &&
                Objects.equals(committedUsage, that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instances, os, machineClass, series, machineType, addGPUs, gpuType, numberOfGPUs, ssd, location, committedUsage);
    }

}
