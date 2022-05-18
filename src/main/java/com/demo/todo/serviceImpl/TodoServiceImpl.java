package com.demo.todo.serviceImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;
import com.demo.todo.dto.AddTaskDto;
import com.demo.todo.dto.PaginationAndListDto;
import com.demo.todo.dto.UpdateRowDto;
import com.demo.todo.dto.http.response.RestResponse;
import com.demo.todo.dto.http.response.StatusResponse;
import com.demo.todo.model.TodoTask;
import com.demo.todo.model.users.Users;
import com.demo.todo.repository.TaskRepository;
import com.demo.todo.repository.UserRepository;
import com.demo.todo.service.TodoService;
import com.demo.todo.validator.Validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;
    

    public RestResponse addUserTask(AddTaskDto task,long userId) {
        TodoTask compTask = new TodoTask();
        compTask.setDescription(task.getDescription());
        compTask.setTaskrow(task.getTaskrow());
        Users u = userRepository.findById(userId);
        compTask.setUsers(u);
        LocalDateTime dateTime = task.getUserTime();
        Timestamp timestamp_object = Timestamp.valueOf(dateTime);
        compTask.setDeadLine(timestamp_object.getTime());
        TodoTask obj = taskRepository.save(compTask);
        return new StatusResponse(200, "Task Created Successfully !", obj);
    }

    public RestResponse fetchAllTasks(int offset,int pageSize,long userId){

        PaginationAndListDto countAndListData = new PaginationAndListDto();
        Users u = userRepository.findById(userId);
        List<TodoTask> allTasks = taskRepository.findByUsersOrderByCreatedAtDesc(u,PageRequest.of((offset-1),pageSize));
        countAndListData.setTasks(allTasks);
        long totalRecordCount = taskRepository.countByUsers(u); 
        int i=(int)totalRecordCount;  
        countAndListData.setCount(i);
        return new StatusResponse(200,"All Data",countAndListData);
    }


    
    public RestResponse fetchTaskByText(int offset,int pageSize,String textSearch1,long userId){
        PaginationAndListDto countAndListData = new PaginationAndListDto();
        Users u = userRepository.findById(userId);
          List<TodoTask> allTasks = taskRepository.findByTaskrowContainingIgnoreCaseAndUsersOrderByCreatedAtDesc(textSearch1, u,PageRequest.of((offset-1),pageSize));
                                                    // findByTaskTitleContainingIgnoreCaseAndUserOrderByCreatedAtDesc
            countAndListData.setTasks(allTasks);  
           long totalRecordCount ;
        if(textSearch1.isEmpty()){
             totalRecordCount = taskRepository.countByUsers(u);
        }else{
            totalRecordCount = taskRepository.countByTaskrowContainingIgnoreCase(textSearch1,u); 
        }
        
        countAndListData.setCount(totalRecordCount);

        return new StatusResponse(200,"All Searched data",countAndListData);

    }

    public RestResponse updateTaskRow(UpdateRowDto updateDto,long userId){
        RestResponse rs = null;
        // list of required parameter in this registration and can be change
        String[] requestedArray = { "id","taskrow",
                "description","userId","deadLine" };
        Validations validations = new Validations();
        // validate user with required fields
        rs = validations.validate(updateDto, requestedArray);
        if (rs != null) {
            StatusResponse ds = (StatusResponse) rs;
            logger.error("Updation of task data validation Error " + ds.getMessage());
            return new StatusResponse(400, ds.getMessage(), null);
        }
            TodoTask updateTodo = new TodoTask();
            Timestamp timestamp_object = Timestamp.valueOf(updateDto.getUserTime());
            updateTodo.setDeadLine(timestamp_object.getTime());
            updateTodo.setDescription(updateDto.getDescription());
            updateTodo.setTaskrow(updateDto.getTaskrow());
            updateTodo.setId(updateDto.getId());
            Users u = userRepository.findById(userId);
            updateTodo.setUsers(u);
           TodoTask td= taskRepository.save(updateTodo);


        return new StatusResponse(200,"All Searched data",td);
    }
   
}
