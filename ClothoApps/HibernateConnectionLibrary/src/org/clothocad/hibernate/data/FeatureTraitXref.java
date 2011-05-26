package org.clothocad.hibernate.data;
// Generated Oct 12, 2010 7:14:51 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * FeatureTraitXref generated by hbm2java
 */
public class FeatureTraitXref  implements java.io.Serializable {


     private FeatureTraitXrefId id;
     private TraitTable traitTable;
     private FeatureTable featureTable;
     private String value;
     private Date dateCreated;
     private Date lastModified;

    public FeatureTraitXref() {
    }

	
    public FeatureTraitXref(FeatureTraitXrefId id, TraitTable traitTable, FeatureTable featureTable) {
        this.id = id;
        this.traitTable = traitTable;
        this.featureTable = featureTable;
    }
    public FeatureTraitXref(FeatureTraitXrefId id, TraitTable traitTable, FeatureTable featureTable, String value, Date dateCreated, Date lastModified) {
       this.id = id;
       this.traitTable = traitTable;
       this.featureTable = featureTable;
       this.value = value;
       this.dateCreated = dateCreated;
       this.lastModified = lastModified;
    }
   
    public FeatureTraitXrefId getId() {
        return this.id;
    }
    
    public void setId(FeatureTraitXrefId id) {
        this.id = id;
    }
    public TraitTable getTraitTable() {
        return this.traitTable;
    }
    
    public void setTraitTable(TraitTable traitTable) {
        this.traitTable = traitTable;
    }
    public FeatureTable getFeatureTable() {
        return this.featureTable;
    }
    
    public void setFeatureTable(FeatureTable featureTable) {
        this.featureTable = featureTable;
    }
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    public Date getDateCreated() {
        return this.dateCreated;
    }
    
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    public Date getLastModified() {
        return this.lastModified;
    }
    
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }




}


