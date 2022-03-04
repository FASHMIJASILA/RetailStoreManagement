package com.cg.retailstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cg.retailstore.model.Retailer;
import com.cg.retailstore.model.Supplier;
import com.cg.retailstore.service.IProductService;
import com.cg.retailstore.service.IRetailerService;
import com.cg.retailstore.service.ISupplierService;

@Controller
public class SupplierController {

	private ISupplierService supplierService;
	private IProductService productService;

	public SupplierController(ISupplierService supplierService, IProductService productService) {
		super();
		this.supplierService = supplierService;
		this.productService = productService;
	}

	@GetMapping("/supplier")
	public String listSupplier(Model model) {
		System.out.println("supplier controller");
		model.addAttribute("listsupplier", supplierService.getAllSuppliers());
		System.out.println("retrieve the data ");
		return "supplier";

	}

	@GetMapping("/supplier/new")
	public String addSupplier(Model model) {
		Supplier supplier = new Supplier();
		model.addAttribute("supplier", supplier);
		return "add-supplier";
	}

	@PostMapping("/supplier")
	public String saveSupplier(@ModelAttribute("suppliers") Supplier suppliers) {
		supplierService.saveSupplier(suppliers);
		return "redirect:/supplier";
	}

	@GetMapping("/supplier/edit/{id}")
	public String editSupplier(@PathVariable("id") String supplier_id, Model model) {

		System.out.println("insid edit  " + supplier_id);

		Long supplier_id1 = Long.parseLong(supplier_id);
		model.addAttribute("supplier", supplierService.getSupplierById(supplier_id1));
		return "edit-supplier";
	}

	@PostMapping("/supplier/{id}")
	public String UpdateSupplier(@PathVariable("id") String supplier_id, @ModelAttribute("suppliers") Supplier supplier,
			Model model) {

		// get Supplier from database by id

		System.out.println("update supplier controller "); // get retailer from database by id
		Long supplier_id1 = Long.parseLong(supplier_id);

		System.out.println("update supplier controller1 ");
		Supplier existingSupplier = supplierService.getSupplierById(supplier_id1);
		existingSupplier.setSupplier_id(supplier_id1);
		existingSupplier.setSupplier_name(supplier.getSupplier_name());
		existingSupplier.setSupplier_phone(supplier.getSupplier_phone());
		existingSupplier.setSupplier_email(supplier.getSupplier_email());
		existingSupplier.setRetailer(supplier.getRetailer());

		// save update Supplier object

		supplierService.updateSupplier(existingSupplier);
		model.addAttribute("listsupplier", supplierService.getAllSuppliers());
		return "supplier";

	}

	@GetMapping("/deleteSupplier/{id}")
	public String deleteSupplier(@PathVariable("id") long supplier_id, Model model) {

		supplierService.deleteSupplierById(supplier_id);
		model.addAttribute("listsupplier", supplierService.getAllSuppliers());
		return "supplier";
	}

	@GetMapping("/supplierProductList")
	public String supplierProductList(Model model) {
		model.addAttribute("listproducts", productService.getAllProducts());
		return "supplier-product-listPage";

	}

}
