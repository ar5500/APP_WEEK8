import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentCourseManagement extends JFrame {

    JList<String> courseList;
    JTable table;
    DefaultTableModel model;

    StudentCourseManagement() {

        setTitle("Student Course Management System");
        setSize(700, 450);
        setLayout(new BorderLayout(10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Available Courses
        String courses[] = {
            "Java Programming",
            "Data Structures",
            "Computer Networks",
            "Database Management",
            "Operating Systems"
        };

        courseList = new JList<>(courses);
        courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane listScrollPane = new JScrollPane(courseList);
        listScrollPane.setBorder(
            BorderFactory.createTitledBorder("Available Courses")
        );

        add(listScrollPane, BorderLayout.WEST);

        // Table
        String columns[] = {
            "Student Name",
            "Course",
            "Enrollment Status"
        };

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBorder(
            BorderFactory.createTitledBorder("Registered Courses")
        );

        add(tableScrollPane, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add Course");
        JButton removeButton = new JButton("Remove Course");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Add Course
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String course = courseList.getSelectedValue();

                if (course == null) {
                    JOptionPane.showMessageDialog(
                        StudentCourseManagement.this,
                        "Please select a course."
                    );
                    return;
                }

                String studentName = JOptionPane.showInputDialog(
                    StudentCourseManagement.this,
                    "Enter Student Name:"
                );

                if (studentName != null && !studentName.isEmpty()) {

                    model.addRow(new Object[] {
                        studentName,
                        course,
                        "Enrolled"
                    });
                }
            }
        });

        // Remove Course
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int row = table.getSelectedRow();

                if (row != -1) {
                    model.removeRow(row);
                } else {
                    JOptionPane.showMessageDialog(
                        StudentCourseManagement.this,
                        "Please select a course to remove."
                    );
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentCourseManagement();
    }
}
