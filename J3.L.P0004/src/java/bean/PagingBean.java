/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.DigitalDB;
import java.io.Serializable;
import java.util.List;
import model.Digital;

/**
 *
 * @author Administrator
 */
public class PagingBean implements Serializable {

    private int page, size;
    private String title;
    private DigitalDB ddb;

    public PagingBean() {
        size = 3;
        page = 1;
        ddb = new DigitalDB();
    }

    public void setPage(int page) {
        this.page = page;
    }
    
    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // return the total pages
    public int getPages() throws Exception {
        int rows = 0;
        rows = ddb.countDigital(title);
        return (int) Math.ceil(rows * 1.0 / size);
    }

    // return list digital from - to with title
    public List<Digital> getList() throws Exception {
        int from = (page - 1) * size + 1;
        int to = page * size;
        List<Digital> list = ddb.digitalFromTo(from, to, title);
        return list;
    }
}
