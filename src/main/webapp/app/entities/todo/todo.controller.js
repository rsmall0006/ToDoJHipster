(function() {
    'use strict';

    angular
        .module('toDoJHipsterApp')
        .controller('TodoController', TodoController);

    TodoController.$inject = ['Todo'];

    function TodoController(Todo) {

        var vm = this;

        vm.todos = [];

        loadAll();

        function loadAll() {
            Todo.query(function(result) {
                vm.todos = result;
                vm.searchQuery = null;
            });
        }
    }
})();
