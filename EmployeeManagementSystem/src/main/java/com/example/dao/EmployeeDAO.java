package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Employee;
import com.example.util.DBConnection;

public class EmployeeDAO {

    public boolean addEmployee(Employee emp) {

        boolean status = false;

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "INSERT INTO employee(name,department,salary,email) VALUES(?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setDouble(3, emp.getSalary());
            ps.setString(4, emp.getEmail());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                status = true;
            }

        } catch(Exception e) {

            e.printStackTrace();

        }

        return status;
    }
    
    public List<Employee> getAllEmployees() {

        List<Employee> list = new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM employee";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                Employee emp =
                        new Employee();

                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setDepartment(rs.getString("department"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setEmail(rs.getString("email"));

                list.add(emp);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return list;
    }
    
    public Employee getEmployeeById(int id) {

        Employee emp = null;

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM employee WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                emp = new Employee();

                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setDepartment(rs.getString("department"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setEmail(rs.getString("email"));
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return emp;
    }
    
    public boolean updateEmployee(Employee emp) {

        boolean status = false;

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "UPDATE employee SET name=?, department=?, salary=?, email=? WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setDouble(3, emp.getSalary());
            ps.setString(4, emp.getEmail());
            ps.setInt(5, emp.getId());

            int rows =
                    ps.executeUpdate();

            if(rows > 0) {

                status = true;
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return status;
    }
    
    public boolean deleteEmployee(int id) {

        boolean status = false;

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "DELETE FROM employee WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows =
                    ps.executeUpdate();

            if(rows > 0) {

                status = true;
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return status;
    }
    public List<Employee> getEmployeesByPage(int start, int total) {

        List<Employee> list = new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM employee LIMIT ?, ?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, start);
            ps.setInt(2, total);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                Employee emp =
                        new Employee();

                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setDepartment(rs.getString("department"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setEmail(rs.getString("email"));

                list.add(emp);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return list;
    }
    public List<Employee> getEmployeesSorted(String column) {

        List<Employee> list = new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            if(!column.equals("name") &&
            		   !column.equals("department") &&
            		   !column.equals("salary")) {

            		    column = "id";
            		}

            		String sql =
            		        "SELECT * FROM employee ORDER BY " + column;

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                Employee emp =
                        new Employee();

                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setDepartment(rs.getString("department"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setEmail(rs.getString("email"));

                list.add(emp);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return list;
    }
}

