package com.kmong.demo.service;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kmong.demo.models.Product;
import com.kmong.demo.repositories.ProductRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements CommandLineRunner {
 
    private final String FILE_INIT_PRODUCT = "config/init_data.json";
 
    private final ProductRepository productrepository;
 
    public ProductService(ProductRepository productrepository) {
        this.productrepository = productrepository;
    }
 
    @Override
    public void run(String... args) throws Exception {
        List<Product> productList = new ArrayList<>();
        productList = getInitProductsFromFile();
        if (productList == null || productList.size() == 0) {
            throw new IllegalArgumentException("no data in init data file.");
        }
 
        for (Product product : productList) {
            productrepository.save(product);
        }
    }
 
    private List<Product> getInitProductsFromFile() throws IOException {
        List<Product> productList = new ArrayList<>();
        try (InputStream is = getStreamFromResource(FILE_INIT_PRODUCT)) {
            JsonNode productNode = getProductNode(is);
            productList = getProductListFromNode(productNode);
        }
 
        return productList;
    }
 
    private InputStream getStreamFromResource(String fileLocation) {
        ClassLoader classLoader = ProductService.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileLocation);
 
        if (inputStream == null) {
            throw new IllegalArgumentException("init data file \"" + fileLocation + "\" not found.");
        } else {
            return inputStream;
        }
    }
 
    private JsonNode getProductNode(InputStream is) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode productNode = null;
        try (DataInputStream dis = new DataInputStream(is)) {
            productNode = objectMapper.readTree(dis).path("product");
        } catch (IOException io) {
            io.printStackTrace();
        }
        return productNode;
    }
 
    private List<Product> getProductListFromNode(JsonNode productNode) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> productList = objectMapper.convertValue(productNode, new TypeReference<List<Product>>() {
        }).stream().collect(Collectors.toList());
        return productList;
    }
    
}
