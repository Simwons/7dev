package kr.co.chill.inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inventory")
public class InventoryViewController {

    @GetMapping("/status")
    public String showStatusPage() {
        return "inventory/inventoryStatus";
    }

    @GetMapping("/documents")
    public String showDocumentsPage() {
        return "inventory/materialDocuments";
    }

    @GetMapping("/report")
    public String showReportPage() {
        return "inventory/inventoryReport";
    }
}