package app.controller;

import app.entity.Customer;
import app.entity.InvalidJsonRequestException;
import app.service.CustomersSearchService;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerInfoController {

    private final CustomersSearchService searchService;

    @PostMapping
    public String postHandler(@RequestParam String data) {
        JSONObject jsonObject = new JSONObject(data);
        try {
            int loan_value = jsonObject.getInt("loan_value");
            int period = jsonObject.getInt("period");
            List<Customer> customers = searchService.getCustomersByLoanAndPeriod(loan_value, period);
            String status = !customers.isEmpty() ? "OK" : "NOT OK";
            JSONObject resp = new JSONObject();
            resp.put("Status", status);
            resp.put("Customers", customers);
            return resp.toString();
        } catch (Exception ex) {
            throw new InvalidJsonRequestException("One or several required parameters may be absent!");
        }
    }

}
