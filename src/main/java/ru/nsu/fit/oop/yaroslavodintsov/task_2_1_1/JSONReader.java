package ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.nsu.fit.oop.yaroslavodintsov.task_2_1_1.employee.Workers;

import java.io.File;
import java.io.IOException;

class JSONReader {

    Workers readParameters(File parameters) {

        try {

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(parameters, Workers.class);

        }

        catch (IOException e) {

            e.printStackTrace();

        }

        return null;

    }

}
