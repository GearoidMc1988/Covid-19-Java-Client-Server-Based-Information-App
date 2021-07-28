
package io.github.gearoidmc1988.covidtracker;


import java.io.Serializable;
import java.util.Date;
 
public class Incidence implements Serializable  {

  private int ref_num;
  private String country_name;
  private String country_code;
  private Date date;
  private int confirmed_cases_num;
  private int confirmed_deaths_num;
  private int confirmed_recoveries_num;
  private int confirmed_cases_incr;
  private int confirmed_deaths_incr;
  private int confirmed_recoveries_incr;
  private int days_since_first;
  private int days_since_100;
  private int confirmed_PopPct;
  private int deaths_PopPct;
  private int recoveries_PopPct;

  

  
  /**Default constructor*/
  public Incidence() { }
 
  public Incidence(int ref_num, String country_name, String country_code, Date date, int confirmed_cases_num, int confirmed_deaths_num,
   int confirmed_recoveries_num, int confirmed_cases_incr, int 	confirmed_deaths_incr, int confirmed_recoveries_incr, 
   int days_since_first, int days_since_100, int confirmed_PopPct, int deaths_PopPct, int recoveries_PopPct) {
      
      
    this.ref_num = ref_num;
    this.country_name = country_name;
    this.country_code = country_code;
    this.date = date;
    this.confirmed_cases_num = confirmed_cases_num;
    this.confirmed_deaths_num = confirmed_deaths_num;
    this.confirmed_recoveries_num = confirmed_recoveries_num;
    this.confirmed_cases_incr = confirmed_cases_incr;
    this.confirmed_deaths_incr = confirmed_deaths_incr;
    this.confirmed_recoveries_incr = confirmed_recoveries_incr;
    this.days_since_first = days_since_first;
    this.days_since_100 = days_since_100;
    this.confirmed_PopPct = confirmed_PopPct;
    this.deaths_PopPct = deaths_PopPct;
    this.recoveries_PopPct = recoveries_PopPct;

  }
 

  public void setRef_num(int ref_num) {
        this.ref_num = ref_num;
    }

    public int getRef_num() {
        return ref_num;
    }
  
    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setConfirmed_cases_num(int confirmed_cases_num) {
        this.confirmed_cases_num = confirmed_cases_num;
    }

    public void setConfirmed_deaths_num(int confirmed_deaths_num) {
        this.confirmed_deaths_num = confirmed_deaths_num;
    }

    public void setConfirmed_recoveries_num(int confirmed_recoveries_num) {
        this.confirmed_recoveries_num = confirmed_recoveries_num;
    }

    public void setConfirmed_cases_incr(int confirmed_cases_incr) {
        this.confirmed_cases_incr = confirmed_cases_incr;
    }

    public void setConfirmed_deaths_incr(int confirmed_deaths_incr) {
        this.confirmed_deaths_incr = confirmed_deaths_incr;
    }

    public void setConfirmed_recoveries_incr(int confirmed_recoveries_incr) {
        this.confirmed_recoveries_incr = confirmed_recoveries_incr;
    }

    public void setDays_since_first(int days_since_first) {
        this.days_since_first = days_since_first;
    }

    public void setDays_since_100(int days_since_100) {
        this.days_since_100 = days_since_100;
    }

    public void setConfirmed_PopPct(int confirmed_PopPct) {
        this.confirmed_PopPct = confirmed_PopPct;
    }

    public void setDeaths_PopPct(int deaths_PopPct) {
        this.deaths_PopPct = deaths_PopPct;
    }

    public void setRecoveries_PopPct(int recoveries_PopPct) {
        this.recoveries_PopPct = recoveries_PopPct;
    }

    public String getCountry_name() {
        return country_name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public Date getDate() {
        return date;
    }

    public int getConfirmed_cases_num() {
        return confirmed_cases_num;
    }

    public int getConfirmed_deaths_num() {
        return confirmed_deaths_num;
    }

    public int getConfirmed_recoveries_num() {
        return confirmed_recoveries_num;
    }

    public int getConfirmed_cases_incr() {
        return confirmed_cases_incr;
    }

    public int getConfirmed_deaths_incr() {
        return confirmed_deaths_incr;
    }

    public int getConfirmed_recoveries_incr() {
        return confirmed_recoveries_incr;
    }

    public int getDays_since_first() {
        return days_since_first;
    }

    public int getDays_since_100() {
        return days_since_100;
    }

    public int getConfirmed_PopPct() {
        return confirmed_PopPct;
    }

    public int getDeaths_PopPct() {
        return deaths_PopPct;
    }

    public int getRecoveries_PopPct() {
        return recoveries_PopPct;
    }
  

  
  
  
  
   @Override
    public String toString() {
        return "ref_Num " + getRef_num() + "\n"
+ "country_name " + getCountry_name() + "\n"
+ "country_code " + getCountry_code() + "\n"
+ "date " + getDate() + "\n"
+ "confirmed_cases_num " + getConfirmed_cases_num() + "\n"
+ "confirmed_deaths_num " + getConfirmed_deaths_num() + "\n"
+ "confirmed_recoveries_num" + getConfirmed_recoveries_num() + "\n"
+ "confirmed_cases_incr " + getConfirmed_cases_incr() + "\n"
+ "confirmed_deaths_incr " + getConfirmed_deaths_incr() + "\n"
+ "confirmed_recoveries_incr" + getConfirmed_recoveries_incr() + "\n"
+ "days_since_first " + getDays_since_first() + "\n"
+ "days_since_100 " + getDays_since_100() + "\n"
+ "confirmed_PopPct " + getConfirmed_PopPct() + "\n"
+ "deaths_PopPct " + getDeaths_PopPct() + "\n"
+ "recoveries_PopPct " + getRecoveries_PopPct() + "\n";
   }//end toString
  
 
        
}


  
