@param com.dev.task_manager.tasks.Task task

<div class="mx-auto max-w-7xl">
    <div class="bg-gray-900 py-10">
        <div class="mt-8 flow-root">
            <div class="inline-block la-w-full py-2 align-middle">
                <form hx-patch="/edit-task/${task.getId().toString()}"
                      hx-target="body"
                      hx-swap="innerHTML">
                    <input id="editTaskInput"
                           type="text"
                           name="description"
                           placeholder="Edit the task"
                           value="${task.getDescription()}"
                           class=" w-100 rounded-md border-0 px-3 py-1.5 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6">
                    <button type="submit"
                            class="w-100 rounded-r-md bg-indigo-500 px-3 py-2 text-center text-sm font-semibold text-white hover:bg-indigo-400 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-500">
                        Confirm Edit
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>