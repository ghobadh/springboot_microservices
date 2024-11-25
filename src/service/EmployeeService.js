import axios  from "axios";
const EMPLOYEE_SERVICE_URL = 'http://localhost:9191/employee-service/employee?employee_id=';
const EMPLOYEE_ID= 8;
class EmployeeService {
    getEmployee(){
        return axios.get(EMPLOYEE_SERVICE_URL +EMPLOYEE_ID)
    }
}

export default new EmployeeService
