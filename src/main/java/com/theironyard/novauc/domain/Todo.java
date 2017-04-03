package com.theironyard.novauc.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A Todo.
 */
@Entity
@Table(name = "todo")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Todo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "datetoaccomplish")
    private LocalDate datetoaccomplish;

    @Column(name = "priority")
    private String priority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Todo name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDatetoaccomplish() {
        return datetoaccomplish;
    }

    public Todo datetoaccomplish(LocalDate datetoaccomplish) {
        this.datetoaccomplish = datetoaccomplish;
        return this;
    }

    public void setDatetoaccomplish(LocalDate datetoaccomplish) {
        this.datetoaccomplish = datetoaccomplish;
    }

    public String getPriority() {
        return priority;
    }

    public Todo priority(String priority) {
        this.priority = priority;
        return this;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Todo todo = (Todo) o;
        if (todo.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, todo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Todo{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", datetoaccomplish='" + datetoaccomplish + "'" +
            ", priority='" + priority + "'" +
            '}';
    }
}
