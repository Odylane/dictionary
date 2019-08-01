package fr.formation.dictonary.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.dictonary.business.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @GetMapping("/{id}") // parmi l'ensemble de factures pas nécessaire
			 // d'ajouter
			 // invoices
    public Invoice invoice(@PathVariable("id") Long id) {
	LocalDate date = LocalDate.of(2018, 12, 26);
	Invoice invoice = new Invoice("A01", date, 1005.36);
	invoice.setPaid(true);
	invoice.setId(id);
	return invoice;
    }

    @GetMapping() // il y a un chemin vers invoices
    public ArrayList<Invoice> getAll(@RequestParam("size") int size,
	    @RequestParam("page") int page) {
	System.out.println("size=" + size + ", page=" + page);
	LocalDate date = LocalDate.of(2018, 12, 26);
	ArrayList<Invoice> invoices = new ArrayList<>();
	Invoice first = new Invoice("A01", date, 1005.36);
	invoices.add(first);
	Invoice second = new Invoice("A01", date, 205.40);
	invoices.add(second);
	return invoices;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
	System.out.println("Deleting invoice with id" + id);
    }

    @PostMapping() // va créer une facture dans invoices
    // @Valid création de règles de validation
    public void create(@RequestBody @Valid Invoice invoice) {
	System.out.println(invoice);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id,
	    @RequestBody Invoice invoice) {
	System.out.println(invoice);
    }

    @PatchMapping("/{id}/paid")
    public void paid(@PathVariable("id") Long id) {
	System.out.println("Paid invoice with id" + id);
    }

    @PatchMapping("/{id}/unpaid")
    public void unpaid(@PathVariable("id") Long id) {
	System.out.println("Unpaid invoice with id" + id);
    }
}
