import dao.AbstractDAO;
import entities.Category;
import entities.Goods;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "managedClass")
@SessionScoped
public class ManagedClass implements Serializable {
    AbstractDAO<Integer,Goods> gdao = new AbstractDAO<Integer, Goods>();
    List<Goods> goods;
    AbstractDAO<Integer,Category> cdao = new AbstractDAO<Integer, Category>();
    List<Category> categories = cdao.selectAll(Category.class);
    Goods good;
    int idcat;
    Category category;

    public ManagedClass(){
//        AbstractDAO<Integer,Goods> gdao = new AbstractDAO<Integer, Goods>();
//        goods=gdao.selectAll(Goods.class);
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Goods getGood() {
        return good;
    }

    public void setGood(Goods good) {
        this.good = good;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String editGoods(Goods good){
        good.setEditable(true);
        return null;
    }


    public String saveGood(Goods good){
        AbstractDAO<Integer,Category> cdao = new AbstractDAO<Integer, Category>();
        Category cat = cdao.getByKey(Category.class,idcat);
        good.setCategoryByIdcategory(cat);
        gdao.update(good,good.getIdgoods());
        saveAction();
        return null;
    }

    public void setGoodsByCat(Category cat){
        goods = new ArrayList<Goods>();
        for(Goods g:gdao.selectAll(Goods.class)){
            if(g.getCategoryByIdcategory().getIdcategory()==cat.getIdcategory()){
                goods.add(g);
            }
        }
        idcat = cat.getIdcategory();
    }

    public String saveAction(){
        for (Goods good:goods) {
            good.setEditable(false);
        }
        return null;
    }

}
