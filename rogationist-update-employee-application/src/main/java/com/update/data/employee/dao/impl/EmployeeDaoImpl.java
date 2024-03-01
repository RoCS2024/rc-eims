package com.update.data.employee.dao.impl;

import com.update.app.model.employee.Employee;
import com.update.data.connection.ConnectionSql;
import com.update.data.employee.dao.EmployeeDao;
import com.update.data.utils.QueryConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    Connection con = ConnectionSql.getConnection();

    @Override
    public List<Employee> getAllStudents() {
        try {
            PreparedStatement stmt = con.prepareStatement(QueryConstant.GET_ALL_EMPLOYEE_STATEMENT);
            ResultSet rs = stmt.executeQuery();
            List<Employee> employees = new ArrayList<>();

            while(rs.next()) {
                employees.add(setEmployee(rs));
            }
            return employees;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Employee getEmployeeById(String id) throws RuntimeException {
        try {
            PreparedStatement stmt = con.prepareStatement(QueryConstant.GET_EMPLOYEE_BY_EMPLOYEE_ID_STATEMENT);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                return setEmployee(rs);
            }

        } catch (Exception e) {

        }
        return null;
    }

    public Employee setEmployee(ResultSet rs) {
        try{
            Employee employee = new Employee();
            employee.setLastName(rs.getString("last_name"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setMiddleName(rs.getString("middle_name"));
            employee.setPositionInRc(rs.getString("position_in_rc"));
            employee.setDateEmployed(rs.getString("date_employed"));
            employee.setBirthdate(rs.getString("birthdate"));
            employee.setBirthplace(rs.getString("birthplace"));
            employee.setSex(rs.getString("sex"));
            employee.setCivilStatus(rs.getString("civil_status"));
            employee.setCitizenship(rs.getString("citizenship"));
            employee.setReligion(rs.getString("religion"));
            employee.setHeight(Double.parseDouble(rs.getString("height")));
            employee.setWeight(Double.parseDouble(rs.getString("weight")));
            employee.setEmail(rs.getString("email"));
            employee.setSssNo(rs.getString("sss_no"));
            employee.setTinNo(rs.getString("tin_no"));
            employee.setPagibigNo(rs.getString("pagibig_no"));
            employee.setEmployeeId(rs.getString("employee_id"));
            return employee;
        }catch(Exception e){

        }
        return null;
    }
}
