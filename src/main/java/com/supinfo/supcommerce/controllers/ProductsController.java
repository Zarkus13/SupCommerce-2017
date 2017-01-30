/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.controllers;

import com.supinfo.supcommerce.db.DaoFactory;
import com.supinfo.supcommerce.db.daos.ProductDao;
import com.supinfo.supcommerce.entities.Product;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Alexis
 */
@ManagedBean
@ViewScoped
public class ProductsController implements Serializable {    
    private ProductDao productDao = DaoFactory.getProductDao();
    private Product productToAdd;
    private List<Product> products;
    private LineChartModel productsChartModel;
    
    @PostConstruct
    public void init() {
        this.productToAdd = new Product();
        this.productsChartModel = new LineChartModel();
        this.productsChartModel.setTitle("Products prices");
        this.productsChartModel.getAxis(AxisType.Y).setLabel("Prices");
        this.productsChartModel.addSeries(new LineChartSeries());
        
        this.populateProductsChart(this.productsChartModel);
    }
    
    public String addProduct() {
        this.productDao.addProduct(this.productToAdd);
        this.products.add(this.productToAdd);
        this.populateProductsChart(this.productsChartModel);
        
        this.productToAdd = new Product();
        
        return "listProducts?faces-redirect=true";
    }    

    private void populateProductsChart(final LineChartModel chartModel) {
        final List<Product> products = this.getProducts();
        
        final ChartSeries s = chartModel.getSeries().get(0);
        for(Product p : products) {
            s.set(p.getId(), p.getPrice());
        }
    }
    
    // GETTERS AND SETTERS 
    
    public Product getProductToAdd() {
        return productToAdd;
    }

    public List<Product> getProducts() {
        if(this.products == null)
            this.products = this.productDao.listAllProducts();
        
        return products;
    }

    public LineChartModel getProductsChartModel() {
        return productsChartModel;
    }
    
}
