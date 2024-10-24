package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Product;
import com.mftplus.demo.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;

    public class ProductService implements Service<Product, Long> {
        @Getter
        private static ProductService productService = new com.mftplus.demo.model.service.ProductService();

        private ProductService() {
        }

        @Override
        public void save(Product product) throws Exception {
            try (CrudRepository<Product, Long> crudRepository = new CrudRepository<>()) {
                crudRepository.save(product);
            }
        }

        @Override
        public void edit(Product product) throws Exception {
            try (CrudRepository<Product, Long> crudRepository = new CrudRepository<>()) {
                crudRepository.edit(product);
            }
        }

        @Override
        public void remove(Long id) throws Exception {
            try (CrudRepository<Product, Long> crudRepository = new CrudRepository<>()) {
                crudRepository.remove(id, Product.class);
            }
        }

        @Override
        public Product findById(Long id) throws Exception {
            try (CrudRepository<Product, Long> crudRepository = new CrudRepository<>()) {
                return crudRepository.findById(id, Product.class);
            }
        }

        @Override
        public List<Product> findAll() throws Exception {
            try (CrudRepository<Product, Long> crudRepository = new CrudRepository<>()) {
                return crudRepository.findAll(Product.class);
            }
        }

        public List<Product> findByName(String name) throws Exception {
            try (CrudRepository<Product, Long> crudRepository = new CrudRepository<>()) {
                HashMap<String, Object> params = new HashMap<>();
                params.put("name", name + "%");
                return crudRepository.findBy("Person.findByName", params, Product.class);
            }
        }
    }