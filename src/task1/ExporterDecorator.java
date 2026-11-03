package task1;

public abstract class ExporterDecorator implements Exporter {
    protected final Exporter wrappedExporter;

    public ExporterDecorator(Exporter wrappedExporter) {
        if (wrappedExporter == null) {
            throw new IllegalArgumentException("Wrapped exporter cannot be null");
        }
        this.wrappedExporter = wrappedExporter;
    }

    protected abstract String transform(String data);

    private String applyTransforms(String data) {
        String inner = wrappedExporter instanceof ExporterDecorator
                ? ((ExporterDecorator) wrappedExporter).applyTransforms(data)
                : data;
        return transform(inner);
    }

    private Exporter baseExporter() {
        return wrappedExporter instanceof ExporterDecorator
                ? ((ExporterDecorator) wrappedExporter).baseExporter()
                : wrappedExporter;
    }

    @Override
    public final void export(String destination, String data) {
        baseExporter().export(destination, applyTransforms(data));
    }
}
