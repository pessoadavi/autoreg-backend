package com.project.autoreg.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity /* gera uma tabela no DB a partir da classe */
public class Regulador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) /* Gera o valor de id automaticamente*/
    private Long id; /* id dado pela aplicação*/

    @NotEmpty
    private String code; /* código do equipamento  */

    @NotEmpty
    private String region; /* área onde se localiza o equipamento */
    
    @NotEmpty
    private String feeder; /* alimentador */

    @NotEmpty
    private String bus; /* Barramento do alimentador */

    @NotEmpty
    private String model; /* modelo do equipamento */

    @NotEmpty
    private String voltage; /* tensão nominal  */

    @NotEmpty
    private String eCurrent; /* corrente elétrica nominal */

    @NotEmpty
    private String lVoltage; /* nível de tensão */

    @NotEmpty
    private String manufacturer; /* fabricante */

    @NotEmpty
    private String yearManufacture; /* ano de fabricação */

    @NotEmpty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM--yyyy")
    private Date dateEnergization; /* data de energização */

    @NotEmpty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM--yyyy")
    private Date lastInspetion; /* data da última inspeção */
    
    @NotEmpty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM--yyyy")
    private Date lastUpdate; /* data da última atualização */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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


