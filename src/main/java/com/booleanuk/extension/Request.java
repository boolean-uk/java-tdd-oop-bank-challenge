package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Request {
    private LocalDateTime date;
    private static int nextId = 0;
    private final int id;
    public AcceptanceStatus status;
    public Request() {
        id = ++nextId;
        status = AcceptanceStatus.Pending;
        date = LocalDateTime.now();
    }
    public AcceptanceStatus getStatus() {
        return status;
    }
    public void setStatus(AcceptanceStatus status) {
        this.status = status;
    }
    public int getId() {
        return id;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request with id: ");
        sb.append(id);
        sb.append(". Submission date: ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        sb.append(date.format(formatter));
        sb.append(". Status: ");
        sb.append(status.name());
        sb.append(".\n");
        return sb.toString();
    }
}
