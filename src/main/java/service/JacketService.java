package service;

import model.Jacket;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class JacketService {
    private List<Jacket> jackets = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(0);

    public JacketService() {
        // Початкові тестові дані
        jackets.add(new Jacket(idCounter.incrementAndGet(), "Nike", "Tech Fleece", 235, "M", ""));
        jackets.add(new Jacket(idCounter.incrementAndGet(), "CP Company", "Nylon Garment", 399, "XL", ""));
    }

    public List<Jacket> getAll() {
        return jackets;
    }

    public Jacket getById(int id) {
        return jackets.stream()
                .filter(j -> j.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Jacket add(Jacket jacket) {
        jacket.setId(idCounter.incrementAndGet());
        jackets.add(jacket);
        return jacket;
    }

    public boolean update(Jacket jacket) {
        Jacket existing = getById(jacket.getId());
        if (existing != null) {
            existing.setBrand(jacket.getBrand());
            existing.setModel(jacket.getModel());
            existing.setPrice(jacket.getPrice());
            existing.setSize(jacket.getSize());
            existing.setImageUrl(jacket.getImageUrl());
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        return jackets.removeIf(j -> j.getId() == id);
    }
}
