package com.example.spring2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ClassTeacherService {

    @Autowired
    private GroupRepository classTeacherRepository;

    @Autowired
    private TeacherRepository teacherRepository;

        static ClassTeacher teacher;
        static ClassTeacher zapisz(String nazwa, double liczba_na) {
            return teacher = new ClassTeacher(nazwa,liczba_na);

            };

    public ClassTeacher getClassTeacherById(Long id) {
        return classTeacherRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono klasy nauczyciela o id: " + id));
    }

    public void addTeacherToClass(Long classTeacherId, Long teacherId) {
        ClassTeacher classTeacher = getClassTeacherById(classTeacherId);
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono nauczyciela o id: " + teacherId));

        classTeacher.getNauczyciele().add(teacher);
        classTeacherRepository.save(classTeacher);
    }
    public void addTeachersToClass(Long classTeacherId, Set<Long> teacherIds) {
        ClassTeacher classTeacher = getClassTeacherById(classTeacherId);
        Set<Teacher> teachers = (Set<Teacher>) teacherRepository.findAllById(teacherIds);
        classTeacher.getNauczyciele().addAll(teachers);
        classTeacherRepository.save(classTeacher);
    }


    public List<ClassTeacher> getAllClassTeachers() {
        return (List<ClassTeacher>) classTeacherRepository.findAll();
    }

    public double calculateFillPercentage(ClassTeacher classTeacher) {
        int currentTeacherCount = classTeacher.getNauczyciele().size();
        double maxTeacherCount = classTeacher.getLiczba_nauczycieli();

        if (maxTeacherCount > 0) {
            return (currentTeacherCount / maxTeacherCount) * 100.0;
        } else {
            return 0.0;
        }
    }


        }




