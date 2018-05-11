package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testSaveInvoice() {
        //Given
        Product product1 = new Product("Product 1");
        Product product2 = new Product("Product 2");
        Product product3 = new Product("Product 3");
        Item item1 = new Item(new BigDecimal(100), 3);
        Item item2 = new Item(new BigDecimal(250), 2);
        Item item3 = new Item(new BigDecimal(10), 7);
        Item item4 = new Item(new BigDecimal(100), 2);

        item1.setProduct(product1);
        item2.setProduct(product2);
        item3.setProduct(product3);
        item4.setProduct(product1);
        product1.getItems().add(item1);
        product1.getItems().add(item4);
        product2.getItems().add(item2);
        product3.getItems().add(item3);


        Invoice invoice1 = new Invoice("FV_NO1");
        Invoice invoice2 = new Invoice("FV_NO2");
        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);
        invoice1.getItems().add(item3);
        invoice2.getItems().add(item4);

        item1.setInvoice(invoice1);
        item2.setInvoice(invoice1);
        item3.setInvoice(invoice1);
        item4.setInvoice(invoice2);

        //When
        invoiceDao.save(invoice1);
        invoiceDao.save(invoice2);

        int id1 = invoice1.getId();
        int id2 = invoice2.getId();

        //Then
        Assert.assertNotEquals(0, id1);
        Assert.assertNotEquals(0, id2);

        //CleanUp
        //invoiceDao.deleteById(id1);
        //invoiceDao.deleteById(id2);
    }

}
