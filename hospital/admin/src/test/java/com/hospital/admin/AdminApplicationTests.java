package com.hospital.admin;

import com.hospital.admin.dao.AppointmentDao;
import com.hospital.admin.dto.AppointmentDetailsResult;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminApplicationTests {

    @Mock
    private AppointmentDao appointmentDao; // 使用 Mock

    @Test
    void testGetAppointmentDetailsByUsername() throws Exception {


    }
}
