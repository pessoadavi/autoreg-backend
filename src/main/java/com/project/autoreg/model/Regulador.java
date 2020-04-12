package com.project.autoreg.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity /* gera uma tabela no DB a partir da classe */
public class Regulador {


    @Id
    @NotEmpty
    private String code; /* Código do equipamento*/

    @NotEmpty
    public String region; /* área onde se localizaça o equipamento */
    
    @NotEmpty
    public String feeder; /* alimentador */

    @NotEmpty
    public String bus; /* Barramento do alimentador */

    @NotEmpty
    public String model; /* modelo do equipamento */

    @NotEmpty
    public String voltage; /* tensão nominal  */

    @NotEmpty
    public String eCurrent; /* corrente elétrica nominal */

    @NotEmpty
    public String lVoltage; /* nível de tensão */

    @NotEmpty
    public String manufacturer; /* fabricante */

    @NotEmpty
    public String yearManufacture; /* ano de fabricação */

    @NotEmpty
    public Date dateEnergization; /* data de energização */

    @NotEmpty
    public Date lastInspetion; /* data da última inspeção */
    
    @NotEmpty
    public Date lastUpdate; /* data da última atualização */

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFeeder() {
        return feeder;
    }

    public void setFeeder(String feeder) {
        this.feeder = feeder;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String geteCurrent() {
        return eCurrent;
    }

    public void seteCurrent(String eCurrent) {
        this.eCurrent = eCurrent;
    }

    public String getlVoltage() {
        return lVoltage;
    }

    public void setlVoltage(String lVoltage) {
        this.lVoltage = lVoltage;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getYearManufacture() {
        return yearManufacture;
    }

    public void setYearManufacture(String yearManufacture) {
        this.yearManufacture = yearManufacture;
    }

    public Date getDateEnergization() {
        return dateEnergization;
    }

    public void setDateEnergization(Date dateEnergization) {
        this.dateEnergization = dateEnergization;
    }

    public Date getLastInspetion() {
        return lastInspetion;
    }

    public void setLastInspetion(Date lastInspetion) {
        this.lastInspetion = lastInspetion;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


}