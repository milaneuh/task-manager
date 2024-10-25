@param com.dev.task_manager.tasks.Task task

<tr>
    <td class="whitespace-nowrap py-4 pl-4 pr-3 text-sm font-medium text-white sm:pl-0">${task.getDescription()}</td>
    <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-300">Pending</td>
    <td class="relative whitespace-nowrap py-4 pl-3 pr-4 text-right text-sm font-medium sm:pr-0">
        <button
                hx-get="/edit-task/${task.getId().toString()}"
                hx-target="body"
                hx-swap="innerHTML"
                class="text-white px-3 w-1/4 hover:bg-sky-300 hover:border-blue-sky-300 rounded-l-md  border-sky-600 bg-sky-600">
            Edit <span class="sr-only">, ${task.getDescription()}</span>
        </button>
        <button hx-delete="/delete-task/${task.getId().toString()}"
                hx-target="closest tr"
                hx-swap="outerHTML"
                class="text-white px-3 w-1/4 hover:bg-red-300 hover:border-red-300 rounded-r-md  border-red-600 bg-red-600">
            Delete<span class="sr-only">, ${task.getDescription()}</span>
        </button>
    </td>
</tr>
