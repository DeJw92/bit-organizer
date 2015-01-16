package pl.edu.knbit.integration;


import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.unitofwork.UnitOfWork;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * @author mciolek
 */
public class TestCommandHandler<T> implements CommandHandler<T> {
    private Optional<CommandMessage<T>> handled = Optional.empty();
    private CompletableFuture<Boolean> future = new CompletableFuture<>();

    @Override
    public Object handle(CommandMessage<T> commandMessage, UnitOfWork unitOfWork) throws Throwable {
        handled = Optional.of(commandMessage);
        future.complete(true);
        return UUID.randomUUID();
    }

    public CompletableFuture<Boolean> getHandledFuture(){
        return future;
    }

    public Optional<CommandMessage<T>> getHandled() {
        return handled;
    }
}
