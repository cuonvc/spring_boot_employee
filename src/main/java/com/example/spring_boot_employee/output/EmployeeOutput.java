package com.example.spring_boot_employee.output;

import com.example.spring_boot_employee.dto.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;

public class EmployeeOutput {
    private int currentPage;
    private int totalPage;
    private List<EmployeeDTO> listResult = new ArrayList<>();

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<EmployeeDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<EmployeeDTO> listResult) {
        this.listResult = listResult;
    }
}
