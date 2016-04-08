package org.supercsv.ext.builder.joda;

import java.lang.annotation.Annotation;

import org.joda.time.Period;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.cellprocessor.joda.FmtPeriod;
import org.supercsv.cellprocessor.joda.ParsePeriod;
import org.supercsv.ext.builder.AbstractCellProcessorBuilder;

/**
 * The cell processor builder for {@link Period} with Joda-Time
 * @since 1.2
 * @author T.TSUCHIE
 *
 */
public class IntervalCellProcessorBuilder extends AbstractCellProcessorBuilder<Period> {

    @Override
    public CellProcessor buildOutputCellProcessor(final Class<Period> type, final Annotation[] annos,
            final CellProcessor processor, final boolean ignoreValidationProcessor) {
        
        CellProcessor cp = processor;
        cp = (cp == null ? new FmtPeriod() : new FmtPeriod(cp));
        
        return cp;
    }
    
    @Override
    public CellProcessor buildInputCellProcessor(final Class<Period> type, final Annotation[] annos,
            final CellProcessor processor) {
        
        CellProcessor cp = processor;
        cp = (cp == null ? new ParsePeriod() : new ParsePeriod(cp));
        
        return cp;
    }
    
    @Override
    public Period getParseValue(final Class<Period> type, final Annotation[] annos, final String strValue) {
        return Period.parse(strValue);
    }
}