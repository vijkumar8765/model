/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.base;

/**
 * BaseTableAware is implemented by entities and embedded objects that have a common set of basic table columns.
 *
 * <p/>Entities in JPA can hook into events, so that base table fields can be updated whenever the entity is being saved
 * back to the database, or upon being loaded from the database.
 *
 * <pre>
 * <p/><table id="crc"><caption>CRC Card</caption>
 * <tr><th> Responsibilities </th></tr>
 * <tr><td> Provide the base table fields. </td></tr>
 * </table>
 * </pre>
 */
public interface BaseTableAware {
    /**
     * Provides the base table fields.
     *
     * @return  The base table fields.
     */
    BaseTable getBaseTable();

    /**
     * Allows the base table fields to be set.
     *
     * @param  baseTable  The base table fields to use.
     */
    void setBaseTable(BaseTable baseTable);

}
