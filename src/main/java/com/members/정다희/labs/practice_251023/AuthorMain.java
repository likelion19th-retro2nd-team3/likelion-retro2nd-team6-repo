package com.members.정다희.labs.practice_251023;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class AuthorMain {
    public static void find(EntityManager em) {
        // 1번 작가를 조회
        Author author = em.find(Author.class, 1L);
        log.info("{} 1번 작가를 조회", "=".repeat(10));
        log.info("author name = {}", author.getName());

        // 1번 책을 조회
        Book book = em.find(Book.class, 1L);
        log.info("{} 1번 책을 조회", "=".repeat(10));
        log.info("book title = {}", book.getTitle());
        log.info("book authorName = {}", book.getAuthor().getName());

        // 1번 작가의 책들을 조회
        List<Book> books = em.find(Author.class, 1L).getBooks();
        log.info("{} 1번 작가의 책들을 조회", "=".repeat(10));
        for (Book b : books) {
            log.info("book title = {}", b.getTitle());
        }
    }

    public static void create(EntityManager em) {
        // 작가 객체 생성
        Author author = new Author();
        author.setName("한강.");

        // 작가의 첫번째 책 생성
        Book book1 = new Book();
        book1.setTitle("소년이온다");
        book1.setAuthor(author);

        // 작가의 두번재 책 생성
        Book book2 = new Book();
        book2.setTitle("작별하지 않는다");
        book2.setAuthor(author);

        // 작가 객체에 생성된 책 객체 추가
        author.getBooks().add(book1);
        author.getBooks().add(book2);

        // 작가와 책들을 한번에 INSERT
        em.persist(author);
    }

    public static void update(EntityManager em) {
        // 5번 작가를 찾음
        Author author = em.find(Author.class, 5L);
        // 수정
        author.setName("한강");
    }

    public static void delete(EntityManager em) {
        // 5번 작가를 찾음
        Author author = em.find(Author.class, 5L);
        // 삭제
        em.remove(author);
    }

    public static void main(String[] args) {
        try (EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager()) {
            em.getTransaction().begin();

//            find(em);
//            create(em);
//            update(em);
            delete(em);

            em.getTransaction().commit();
        }
    }
}
