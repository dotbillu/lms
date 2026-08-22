package com.lms.model;

import java.time.LocalDate;
import java.util.UUID;

//TODO: use it later if(Ifff) i implement a read(),return unauthorized there;
public class BorrowedBook {
  UUID id;
  LocalDate borrowDate;
  LocalDate dueDate;
}
