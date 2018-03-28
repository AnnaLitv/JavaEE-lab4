package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
    private int idcategory;
    private String name;

    public Category(){}

    public Category(int idcategory){
        this.idcategory = idcategory;
        if(idcategory==1){
            this.name="Торт";
        }else if(idcategory==2){
            this.name="Мороженое";
        }else if(idcategory==3){
            this.name="Печенье";
        }

    }

    @Id
    @Column(name = "idcategory", nullable = false)
    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (idcategory != category.idcategory) return false;
        if (name != null ? !name.equals(category.name) : category.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcategory;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
