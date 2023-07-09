#include <gtk/gtk.h>

// Callback function for the "clicked" signal of the button
void on_button_clicked(GtkWidget *widget, gpointer data)
{
    g_print("Hello, World!\n");
}

int main(int argc, char *argv[])
{
    GtkWidget *window;
    GtkWidget *button;

    // Initialize GTK
    gtk_init(&argc, &argv);

    // Create the main window
    window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    gtk_window_set_title(GTK_WINDOW(window), "Hello, World!");

    // Create a button
    button = gtk_button_new_with_label("Click Me!");

    // Connect the "clicked" signal of the button to the callback function
    g_signal_connect(button, "clicked", G_CALLBACK(on_button_clicked), NULL);

    // Add the button to the main window
    gtk_container_add(GTK_CONTAINER(window), button);

    // Show all the widgets
    gtk_widget_show_all(window);

    // Start the main GTK loop
    gtk_main();

    return 0;
}
