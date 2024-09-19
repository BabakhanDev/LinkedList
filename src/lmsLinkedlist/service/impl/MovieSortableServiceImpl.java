package lmsLinkedlist.service.impl;

import lmsLinkedlist.dao.MuvieDao;
import lmsLinkedlist.dao.MuviesortDao;
import lmsLinkedlist.dao.impl.MuvieDaoImpl;
import lmsLinkedlist.dao.impl.MuvieSortDaoImpl;
import lmsLinkedlist.models.Movie;
import lmsLinkedlist.service.MovieSortableService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MovieSortableServiceImpl implements MovieSortableService {
    private final MuviesortDao muviesortDao = new MuvieSortDaoImpl();

    @Override
    public void sortMovieByName(String ascOrDesc) {
        muviesortDao.sortMovieByName(ascOrDesc);

    }


    @Override
    public void sortByYear(String ascOrDesc) {
        muviesortDao.sortByYear(ascOrDesc);

    }

    @Override
    public void sortByProducer(String nameOrLastName) {
        muviesortDao.sortByProducer(nameOrLastName);
    }
}
